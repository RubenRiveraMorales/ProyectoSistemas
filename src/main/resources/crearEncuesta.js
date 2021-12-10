var btnAgregarPregunta = document.getElementById("btnAgregar");

var listaPreguntas = document.getElementById("preguntasLista");

btnAgregarPregunta.addEventListener("click", function() {

    let contenedorPregunta = document.createElement("li");
    let pregunta = document.createElement("div");
    let labelPregunta = document.createElement("label");
    let btnBorrar = document.createElement("button");
    let btnRespuestas = document.createElement("button");
    let videoPregunta = document.createElement("embed");

    //<object style="width:100%;height:100%;width: 820px; height: 461.25px; float: none; 
    //clear: both; margin: 2px auto;" data="http://www.youtube.com/embed/GlIzuTQGgzs"></object>

    pregunta.style.border = "thin solid #00CC66";
    pregunta.style.marginTop = "20px";
    pregunta.style.padding = "30px";
    pregunta.style.display = "flex";
    pregunta.style.justifyContent = "center";
    pregunta.style.alignItems = "center";

    videoPregunta.height = "450px";
    videoPregunta.width = "350px";
    videoPregunta.src = document.getElementById("inputVideo").value;
    videoPregunta.allowFullscreen = true;
    videoPregunta.title = "Adobe Flash Player";
    videoPregunta.wmode = "transparent";
    videoPregunta.type = "application/x-shockwave-flash"

    btnBorrar.style.marginRight = "20px";
    btnRespuestas.style.marginRight = "20px";

    labelPregunta.innerHTML = document.getElementById("inputPregunta").value;
    btnBorrar.innerHTML = "Borrar pregunta";
    btnRespuestas.innerHTML = "Agregar respuesta";

    pregunta.appendChild(labelPregunta);
    pregunta.appendChild(btnBorrar);
    pregunta.appendChild(btnRespuestas);
    pregunta.appendChild(videoPregunta);
    contenedorPregunta.appendChild(pregunta);

    listaPreguntas.appendChild(contenedorPregunta);

})