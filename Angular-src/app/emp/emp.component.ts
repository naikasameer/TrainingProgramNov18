import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {

  //declare the variables: <name>: <type>
  empno: number
  name: string
  department: string
  projects:Project[]
  isEditable:boolean
  isAddingProject:boolean
  joiningDate:Date
  bandColor:string
  isvalidProject:boolean
  message:string
  displaymessage:string
  // is executed when the object is created
  
  constructor(private prjsvc:ProjectService) {  
        // import the Project Service in component
    this.displaymessage=""
    this.empno=11988
    this.name="Sameer A. Naik"
    this.department="L&D"
    this.joiningDate= new Date()
    this.bandColor=""

    this.projects= [
          {projectid:1,name:"Admin",location:"UK"},
          {projectid:2,name:"App",location:"US"},
          {projectid:3,name:"Mobile",location:"IN"}
        ]
    this.isEditable=false
    this.isAddingProject=false
    this.isvalidProject=true
    this.message=""
    //localStorage.setItem("empno",this.empno.toString())
    //localStorage.setItem("empProjects",JSON.stringify(this.projects))
  }

  ngOnInit() {
    this.empno = Number.parseInt(localStorage.getItem("empno"))
    this.joiningDate = new Date(Date.parse(localStorage.getItem("joiningDate")))
   // this.projects = JSON.parse(localStorage.getItem("empProjects"))

   // fetch the data using Project Service
    this.prjsvc.getProjectList(this.empno).subscribe(
      response=>{
         this.projects = response
      })
  }

  toggleEditFields(){
    this.isEditable=!this.isEditable
    localStorage.setItem("empno",this.empno.toString())
    
    this.joiningDate= new Date(this.joiningDate)
    localStorage.setItem("joiningDate",this.joiningDate.toDateString())
  }

  showProjectForm(){
    this.isAddingProject=true
  }

  deleteProject(projectid:number){
    this.prjsvc.deleteProject(this.empno,projectid) // Push the changes to server
      .subscribe(res=>{
        //display the response from server
          this.displaymessage=res.displaymessage
        
        //fetch the updated list from the server
          this.prjsvc.getProjectList(this.empno).subscribe( 
            // pull the latest data from server
            res=>{this.projects=res}
          )
      })
    //this.projects.splice(index,1) // deletes one object starting from the index provided
    //localStorage.setItem("empProjects",JSON.stringify(this.projects))
  }

  addNewProject(newProject:Project){
    if(isNaN(newProject.projectid)){
      this.isvalidProject=false
      this.message="Enter Valid Project Id"
    }
    else if(newProject.name.length<4){
      this.isvalidProject=false
      this.message="Enter Valid Project Name"
    }
    else if(newProject.location.length<2){
      this.isvalidProject=false
      this.message="Enter Valid Project Location"
    }
    else{
      //this.projects.push(newProject)
      //localStorage.setItem("empProjects",JSON.stringify(this.projects))
                  //post data to service
                  
          this.prjsvc.addNewProject(this.empno,newProject).subscribe( 
          res=>{
              this.displaymessage=res.displaymessage
              // pull the data from service
              this.prjsvc.getProjectList(this.empno).subscribe(
                res=>{  this.projects=res }
              )
          })

      this.isAddingProject=false
      this.isvalidProject=true
      this.message=""
    }
    }
}