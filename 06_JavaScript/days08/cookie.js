/**
 * cookie.js
 */
 /*
 function setCookie( cname, cvalue, exdays){
    let now = new Date();
   now.setDate(  now.getDate() + exdays );
   let expires = now.toUTCString();
   
   // 쿠키 저장
   document.cookie = `${cname}=${escape(cvalue)}; expires=${expires}; path=/`;   
 }
 */
 
 function setCookie( cname, cvalue, exdays, path = "/"){
    let now = new Date();
   now.setDate(  now.getDate() + exdays );
   let expires = now.toUTCString();
   
   // 쿠키 저장
   document.cookie = `${cname}=${escape(cvalue)}; expires=${expires}; path=${path}`;   
 }
 
 function getAllCookies(){ 
   let cookies = document.cookie; 
   return cookies;
 }

function getCookie( cname ){ 
   let cookies = document.cookie;   
   let cvalue;    
   let cookieArr = cookies.split(/;\s/); 
   
   cookieArr.forEach(function (elemt, index, array){
      let cnvArr = elemt.split("=");
      if ( cnvArr[0] == cname ) {
         cvalue = unescape( cnvArr[1] );
         // break;
      }
   });
   
   if (cvalue) {
      return cvalue;
   } else {
        return null;
   } 
      
}
function delCookie(cname, path){ 
   let now = new Date();
   now.setDate(  now.getDate() - 10 );
   let expires = now.toUTCString(); 
   document.cookie = `${cname}=; expires=${expires}; path=${path}`; 
}






