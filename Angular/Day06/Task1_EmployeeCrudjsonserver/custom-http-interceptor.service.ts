import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError} from 'rxjs';
import { catchError, retry  } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomHttpInterceptorService {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>
  {
      // code to intercept the request
      console.log("message from custom http interceptor");
      const hardcodedToken = '1d38d128-0671-4121-8084-f6332a992a40';

      // Generated modifed request object
      let updatedReq:HttpRequest<any> = req.clone({
       setHeaders: {
           Authorization: `Bearer ${hardcodedToken}`
       }
      });

  		return next.handle(updatedReq)
      .pipe(
  
        retry(3),

        // Handle errors
        catchError((error: HttpErrorResponse) => {

          console.log(`Error Message from HTTP Interceptor : ${req.url}, StatusCode : ${error.status} `);

         if(error.status === 404)
         {
           console.log("The requested resource could not be found -- custom message");
         }
         else
         {
           console.log(error.message);
         }

          return throwError(() => new Error(error.message));
        })
      );
 }
}
