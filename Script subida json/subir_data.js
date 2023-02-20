//declaramos un diccionario
//obtenemos el json
const json= require('./municipios.json');    const retorno = {};
//recorremos el json controlando que cambie '/' por '-' y lo escribimos en la variable 'retorno'
const j = json.forEach((obj)=>{  
    if(obj.nombre.includes("/")){
        nom = obj.nombre.replace("/","-");
        retorno[nom] = {"municipio_id": obj.municipio_id};
    }else{
        retorno[obj.nombre] = {"municipio_id": obj.municipio_id};
    }
});
//obtengo el permiso de firebase-admin
const admin = require('firebase-admin');
//obtengo la key 
const serviceAccount = require('./key.json');

const collectionKey = 'municipiosEspaña';
//
admin.initializeApp({
    credential: admin.credential.cert(serviceAccount)
});
const firestore = admin.firestore();
const settings = {timestampsInSnapshots: true};
firestore.settings(settings);
if(retorno&&(typeof retorno ==="object")){
    Object.keys(retorno).forEach(docKey=>{
        firestore.collection(collectionKey).doc(docKey).set(retorno[docKey]).then((res)=>{
            console.log("Documento "+docKey+" escrito correctamente!");
        }).catch((error)=>{
            console.error("Error al escribirlo: ",error);
        })
    })
}