enum DiscountType {NEW15=15,WEEKEND25=25};
let totalTypesOfDiscount : number | DiscountType;
let productName : string;
let unitPrice:number;
let quantity:number;
let deliverToHome:boolean;


function getDiscountedPrice(unitPrice:number,quantity:number,totalTypesOfDiscount:DiscountType|number) : number {
    let totalPrice=(unitPrice*quantity);
    let discountedPrice= totalPrice - ((totalPrice*totalTypesOfDiscount)/100)
    return discountedPrice;
    
    

}

productName = "Refrigrator";
unitPrice=15000;
quantity=5;
deliverToHome=true;
totalTypesOfDiscount=DiscountType.NEW15;
console.log(`Product name = ${productName} , Unit price = ${unitPrice} , Quantity = ${quantity} , 
Discount = ${totalTypesOfDiscount} , Total Price = ${getDiscountedPrice(unitPrice,quantity,totalTypesOfDiscount)+(deliverToHome?30:0)} , Deilvery Mode = ${deliverToHome?"Deliver To Home":"Store Pickup"}`);

