var Customer = /** @class */ (function () {
    function Customer(customerId, customerName, customerCity) {
        if (customerId === void 0) { customerId = 0; }
        if (customerName === void 0) { customerName = ""; }
        if (customerCity === void 0) { customerCity = ""; }
        this.customerId = 0;
        this.customerName = "";
        this.customerCity = "";
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerCity = customerCity;
    }
    Customer.prototype.showDetails = function () {
        console.log("customerId : ".concat(this.customerId, ",customerName : ").concat(this.customerName, ",customerCity:").concat(this.customerCity));
        // console.log("Student Id : " + this.customerId);
        // console.log("Student Id : " + this.customerName);
        // console.log("Student Id : " + this.customerCity);
    };
    return Customer;
}());
var c1 = new Customer();
var c2 = new Customer(657, "Amol", "warora");
var c3 = new Customer(866);
var c4 = new Customer(879, "Amol");
c1.showDetails();
c2.showDetails();
c3.showDetails();
c4.showDetails();
