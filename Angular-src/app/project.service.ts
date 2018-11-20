import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Project} from './project'
import { Observable } from 'rxjs';
// declares the service in application module
@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  rootURL:string

  // include HttpClient object on startup
  constructor(private httpsvc:HttpClient) {
      this.rootURL="http://localhost:3990/projects/"
   }

   getProjectList(empno:number):Observable<Project[]>{
      return this.httpsvc.get<Project[]>(
            this.rootURL+"list/"+empno)
      //http://localhost:3990/projects/list/11988      
   }

   deleteProject(empno,pid):Observable<any>{
    return this.httpsvc.delete<any>(
      this.rootURL+"delete/"+empno+"/"+pid)
  }

  addNewProject(empno:number,newProject:Project):Observable<any>{

    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
      }
    
    var reqBody="empno="+empno+"&pid="+newProject.projectid+
          "&pname="+newProject.name+"&ploc="+newProject.location

    return this.httpsvc.post<any>(
      this.rootURL+"register",reqBody,httpOpts)
  }

}
