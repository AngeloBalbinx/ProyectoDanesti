/**
 * 
 */
 window.addEventListener('load',function(){

document.getElementById('fecha').type= 'text';

document.getElementById('fecha').addEventListener('blur',function(){

document.getElementById('fecha').type= 'text';

});

document.getElementById('fecha').addEventListener('focus',function(){

document.getElementById('fecha').type= 'date';

});

});