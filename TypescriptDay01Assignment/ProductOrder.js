var DiscountType;
(function (DiscountType) {
    DiscountType[DiscountType["NEW15"] = 15] = "NEW15";
    DiscountType[DiscountType["WEEKEND25"] = 25] = "WEEKEND25";
})(DiscountType || (DiscountType = {}));
;
var totalTypesOfDiscount;
var productName;
var unitPrice;
var quantity;
var deliverToHome;
function getDiscountedPrice(unitPrice, quantity, totalTypesOfDiscount) {
    var totalPrice = (unitPrice * quantity);
    var discountedPrice = totalPrice - ((totalPrice * totalTypesOfDiscount) / 100);
    return discountedPrice;
}
productName = "Refrigrator";
unitPrice = 15000;
quantity = 5;
deliverToHome = true;
totalTypesOfDiscount = DiscountType.NEW15;
console.log("Product name = ".concat(productName, " , Unit price = ").concat(unitPrice, " , Quantity = ").concat(quantity, " , \nDiscount = ").concat(totalTypesOfDiscount, " , Total Price = ").concat(getDiscountedPrice(unitPrice, quantity, totalTypesOfDiscount) + (deliverToHome ? 30 : 0), " , Deilvery Mode = ").concat(deliverToHome ? "Deliver To Home" : "Store Pickup"));
