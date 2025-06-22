// A simple RESTful Order Service using Actix Web
// - Base path: /orders
// - POST /add: Adds a new order via JSON
// - GET /get: Returns all orders in memory

use actix_web::{web, App, HttpResponse, HttpServer, Responder};
use serde::{Deserialize, Serialize};
use std::sync::Mutex;

#[derive(Serialize, Deserialize, Clone)]
struct Order {
    id: u32,
    item: String,
}

// Shared state to store orders
struct AppState {
    orders: Mutex<Vec<Order>>,
}

// POST /orders/add
// Adds a new order to shared memory
// Input: JSON { "id": u32, "item": String }
// Output: String response "Order added successfully"
async fn add_order(data: web::Data<AppState>, order: web::Json<Order>) -> impl Responder {
    let mut orders = data.orders.lock().unwrap();
    orders.push(order.into_inner());
    HttpResponse::Ok().body("Order added successfully")
}

// GET /orders/get
// Returns all stored orders as JSON
// Input: none
// Output: JSON array of orders
async fn get_orders(data: web::Data<AppState>) -> impl Responder {
    let orders = data.orders.lock().unwrap();
    HttpResponse::Ok().json(&*orders)
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    let shared_state = web::Data::new(AppState {
        orders: Mutex::new(Vec::new()),
    });

    HttpServer::new(move || {
        App::new()
            .app_data(shared_state.clone())
            .service(
                web::scope("/orders")
                    .route("/add", web::post().to(add_order))
                    .route("/get", web::get().to(get_orders)),
            )
    })
    .bind("127.0.0.1:8080")?
    .run()
    .await
}
