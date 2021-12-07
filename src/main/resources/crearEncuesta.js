var btnAgregarPregunta = document.getElementById("btnAgregar");

var listaPreguntas = document.getElementById("preguntasLista");

btnAgregarPregunta.addEventListener("click", function() {

    let contenedorPregunta = document.createElement("li");
    let pregunta = document.createElement("div");
    let labelPregunta = document.createElement("label");
    let btnBorrar = document.createElement("button");
    let btnRespuestas = document.createElement("button");
    let videoPregunta = document.createElement("video");

    pregunta.style.border = "thin solid #00CC66";
    pregunta.style.marginTop = "20px";
    pregunta.style.padding = "30px";
    pregunta.style.display = "flex";
    pregunta.style.justifyContent = "center";
    pregunta.style.alignItems = "center";

    videoPregunta.controls = true;
    videoPregunta.style.width = "400px";
    videoPregunta.style.height = "200px"

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