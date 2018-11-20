const express = require('express')
const app = express()
const port = 3990

var bodyparser = require("body-parser")
app.use(bodyparser.urlencoded({extended:false}))
app.use(bodyparser.json())

var empData = {
                empno:11988,
                projects:[
                    {projectid:1001,name:"Admin",location:"UK"},
                    {projectid:1002,name:"App",location:"US"},
                    {projectid:1003,name:"Mobile",location:"IN"}
                ]
            }

//  Cross -Origin Request Support: Alloeing Access to limited or all types of request
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers",
         "Origin, X-Requested-With, Content-Type, Accept");
    res.header("Access-Control-Allow-Methods","GET,PUT,POST,DELETE");
    next();
})

app.get('/', (req, res) => {
    var message="Welcome to Mastek Employee Application"
    res.send(message)
    console.log(message)
})

// format of Express Web API Methods
//<app-name>.<http-method>(<URL-path>,(req,res)=>{ busines logic for processing response})

// http://localhost:3990/projects/list/11988

// /projects/list/:path-variable-name 
app.get('/projects/list/:empno',(req,res) => {
    var empno = req.params.empno
    var message = "Fetching "+empData.projects.length+
                " Projects for Employee :"+empno
    console.log(message)
    res.send(empData.projects)
})


// http://localhost:3990/projects/delete/11988/123

app.delete('/projects/delete/:empno/:projectid',(req,res)=>{
    var empno = req.params.empno
    var projectId = req.params.projectid
    var message = "Deleting Project "+projectId+" for Employee :"+empno

    for(var i=0;i<empData.projects.length;i++){
        if(empData.projects[i].projectid==projectId){
            empData.projects.splice(i,1)
            break;
        }
    }
    console.log(message)
    res.send({displaymessage:message}) // a json Object as a response 
})

app.post('/projects/register',(req,res)=>{

    var empno = req.body.empno
    var pid = req.body.pid
    var pname = req.body.pname
    var ploc = req.body.ploc

    var message = "Registering Project for Employee :"+empno+
    " Project :[pid="+pid+", pname:"+pname+", location:"+ploc+"]"

    empData.projects.push({
        projectid:pid,
        name:pname,
        location:ploc})

    res.send({displaymessage:message})
    console.log(message)

})

//listen: Host the API on a specified Port 
app.listen(port, () =>{
    console.log('Mastek Employee app listening on port: '+port);
    console.log("Service App Startup logic");
})