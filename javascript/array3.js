deleteData=(arr,search)=>
{
    if(Array.isArray(arr))
    {
      let index=arr.findIndex( (ele)=>ele.includes(search) )
      arr.splice(index,1)
   }
}

let courses=["java","python",".net","jsp","spring"]
deleteData(courses, "python")
console.log(courses)