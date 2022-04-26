var ProductDetails = /** @class */ (function () {
    function ProductDetails(pid) {
        this.pid = 0;
        this.productName = "";
        this.unitPrice = 0;
        this.qty = 1;
        this.pid = pid;
    }
    Object.defineProperty(ProductDetails.prototype, "productId", {
        get: function () {
            return this.pid;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(ProductDetails.prototype, "ProductName", {
        get: function () {
            return this.productName;
        },
        set: function (value) {
            this.productName = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(ProductDetails.prototype, "UnitPrice", {
        get: function () {
            return this.unitPrice;
        },
        set: function (value) {
            this.unitPrice = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(ProductDetails.prototype, "Quantity", {
        get: function () {
            return this.qty;
        },
        set: function (value) {
            this.qty = value;
        },
        enumerable: false,
        configurable: true
    });
    return ProductDetails;
}());
var productObj = new ProductDetails(123);
productObj.ProductName = "Product1";
productObj.UnitPrice = 100;
console.log("Prodcut Id: " + productObj.productId);
console.log("Prodcut Name: " + productObj.ProductName);
console.log("Prodcut UnitPrice: " + productObj.UnitPrice);
console.log("Prodcut Quantity: " + productObj.Quantity);
