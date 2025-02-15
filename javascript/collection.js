let data = {
                "id":10,
                "name":"Jagadeesh"
            }

//console.log(data["name"])

let db = [ {
    "id":10,
    "name":"Jagadeesh"
        },
        {
            "id":20,
            "name":"Vikram"
                },
        ]

db.forEach ( ele => console.log(ele["name"]))