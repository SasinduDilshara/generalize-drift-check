import ballerina/http;

type Order record {|
    int id;
    string item;
|};

final Order[] orders = [];

// A simple RESTful Order Service using Ballerina
// - Base path: /orders
// - POST /take: Adds a new order from JSON body
// - GET /get: Returns all added orders as JSON

service /orders on new http:Listener(8080) {

    // POST /orders/add
    // Accepts a JSON object to add an order to memory
    // Input: JSON { "id": int, "item": string }
    // Output: number of
    resource function post add(@http:Payload Order 'order) returns string {
        orders.push('order);
        return "Order added successfully";
    }

    // GET /orders/get
    // Returns all orders currently in memory
    // Input: none
    // Output: JSON array of orders
    resource function get get() returns Order[] {
        return [];
    }
}
