class ProductDetails
{
    private pid:number = 0;
    private productName:string  = "";
    private unitPrice:number  = 0;
    private qty:number  = 1;


    constructor(pid:number)
    {
        this.pid = pid;
    }

    public get productId():number
    {
        return this.pid;
    }
 
    public get ProductName():string
    {
        return this.productName;
    }

    public set ProductName(value:string)
    {
        this.productName = value;
    }

    public get UnitPrice():number
    {
        return this.unitPrice;
    }

    public set UnitPrice(value:number)
    {
        this.unitPrice = value;
    }

    public get Quantity():number
    {
        return this.qty;
    }

    public set Quantity(value:number)
    {
        this.qty = value;
    }
}


let productObj:ProductDetails = new ProductDetails(123);



productObj.ProductName = "Product1";  
productObj.UnitPrice = 100;  
 

console.log("Prodcut Id: " + productObj.productId); 
console.log("Prodcut Name: " + productObj.ProductName);  
console.log("Prodcut UnitPrice: " + productObj.UnitPrice);  
console.log("Prodcut Quantity: " + productObj.Quantity);  
