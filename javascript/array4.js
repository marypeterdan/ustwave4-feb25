let courses=["java","python",".net","jsp","spring"]

let resultarr=courses.map( (cobj)=> cobj.toUpperCase() )

//console.log(resultarr)

let numbers=[2,4,56,9,15]

let resultarr1=numbers.map( (num)=> num*num )
//console.log(resultarr1)

let result3=numbers.map( (num)=>{
                                if((num%2)===0)
                                    return "even";
                                else
                                return "odd";
                            })
console.log(result3)

// from the given array, display the "odd" or "even" using map