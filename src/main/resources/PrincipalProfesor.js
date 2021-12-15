var btnCerrarSesion = document.getElementById("btnCerrarSesion");

btnCerrarSesion.addEventListener("click", function() {

    window.location.href = "/src/main/resources/Logeo.html";

});

var btnCrearEncuesta = document.getElementById("btnCrearEncuesta");

btnCrearEncuesta.addEventListener("click", function() {

    window.location.href = "/src/main/resources/crearEncuestas.html";

});

var btnVerResultados = document.getElementById("btnVerResultados");

btnVerResultados.addEventListener("click", function() {

    alert("No pueden verse los resultados porque no se pueden crear las encuestas por el problema no solucionado por el video");

})