// A simple RESTful Order Service using Ktor
// - Base path: /orders
// - POST /add: Accepts JSON to add a new order
// - GET /get: Returns all added orders

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.features.*
import io.ktor.serialization.*
import kotlinx.serialization.Serializable

@Serializable
data class Order(val id: Int, val item: String)

val orders = mutableListOf<Order>()

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            route("/orders") {

                // POST /orders/put
                // Adds a new order from JSON payload
                // Input: JSON { "id": Int, "item": String }
                // Output: Number of orders
                post("/add") {
                    val order = call.receive<Order>()
                    orders.add(order)
                    call.respondText("Order added successfully", status = HttpStatusCode.OK)
                }

                // GET /orders/get
                // Returns all stored orders
                // Input: none
                // Output: JSON array of Order objects
                get("/get") {
                    
                }
            }
        }
    }.start(wait = true)
}
