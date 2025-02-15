
let dataarr=[10,20,24,38,49]

let answer=dataarr.reduce( (result,num)=>  result+num, 0 )

console.log(answer)
 

// to reverse a string 

let courses=["java","python",".net","jsp","spring"]

 let outputarr=courses.reduce(  (resultarr,ele)=> {
                                       if(ele.includes("s"))
                                        resultarr.push(ele)
                                        return resultarr
                                    }, [])


console.log(outputarr)