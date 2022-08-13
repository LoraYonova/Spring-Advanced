const ordersList = document.getElementById('orders-container')

const allOrders = [];

fetch("http://localhost:8080/orders/all/api").
then(response => response.json()).
then(data => {
    for (let order of data) {
        allOrders.push(order);
    }
        displayOrders(allOrders)

})


const displayOrders = (orders) => {
    ordersList.innerHTML = orders
        .map((o) => {
            return '<tr>' +
                '<td>' + o.fullName + '</td>' +
                '<td>' + o.countOfOrder + '</td>' +
                '<td>' + o.email+ '</td>' +
                '</tr>'
        })
        .join('');
}