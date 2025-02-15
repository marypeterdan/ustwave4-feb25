
// function order(product)
// {
//     const regex = /[']/g;
//     return (product.search(regex))
// }


// let fun= (product)=> { const regex = /[']/g;
//     return (product.search(regex))}



//console.log(fun("banana c'hips"))


const output=(num)=>{
    return num*num
}

console.log(output(4))







function funMain(f1,product)
{
   a= f1(product)
   return a;
}

let ans= funMain( ((product)=> { const regex = /[']/g; return (product.search(regex))} ), "banana c'hips")
console.log(ans)


let ans1= funMain( ((product)=> {return product.toUpperCase()} ), "banana c'hips")
console.log(ans1)


let ans3=funMain((product)=>product.length,"fridge")