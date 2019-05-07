/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var xmlHttp;

function cidadeSelecionada(str) {
    if (typeof XMLHttpRequest !== "undefined") {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlHttp === null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }

    var url = "filtro_cidade";
    url += "?cidade=" + str;
    xmlHttp.onreadystatechange = atualizaCidades;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
}

function atualizaCidades() {
    if (xmlHttp.readyState === 4 || xmlHttp.readyState === "complete") {
        document.getElementById("cidades").innerHTML = xmlHttp.responseText;
    }
}
