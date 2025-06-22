// A simple RESTful Order Service using Go's net/http package
// - Base path: /orders
// - POST /add: Accepts JSON and adds an order
// - GET /get: Returns all stored orders

package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"
	"sync"
)

type Order struct {
	ID   int    `json:"id"`
	Item string `json:"item"`
}

var (
	orders []Order           // Slice to hold orders
	mutex  = &sync.Mutex{}   // Mutex to handle concurrent access
)

// addOrder handles POST /orders/add
// Accepts JSON { "id": int, "item": string }
// Returns a plain success message
func addOrder(w http.ResponseWriter, r *http.Request) {
	if r.Method != http.MethodPost {
		http.Error(w, "Only POST method is allowed", http.StatusMethodNotAllowed)
		return
	}
	var order Order
	err := json.NewDecoder(r.Body).Decode(&order)
	if err != nil {
		http.Error(w, "Invalid JSON body", http.StatusBadRequest)
		return
	}
	mutex.Lock()
	orders = append(orders, order)
	mutex.Unlock()
	fmt.Fprint(w, "Order added successfully")
}

// getOrders handles GET /orders/get
// Returns a JSON array of all stored orders
func getOrders(w http.ResponseWriter, r *http.Request) {
	if r.Method != http.MethodGet {
		http.Error(w, "Only GET method is allowed", http.StatusMethodNotAllowed)
		return
	}
	mutex.Lock()
	defer mutex.Unlock()
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(orders)
}

func main() {
	http.HandleFunc("/orders/add", addOrder)
	http.HandleFunc("/orders/get", getOrders)

	fmt.Println("Server started on http://localhost:8080")
	log.Fatal(http.ListenAndServe(":8080", nil))
}
