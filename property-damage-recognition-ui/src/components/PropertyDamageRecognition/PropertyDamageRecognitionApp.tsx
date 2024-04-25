import React, { useEffect } from 'react';
import axios from 'axios';


const PropertyDamageRecognitionApp = () => {

    useEffect(() => {
        console.log("evaldas")
        axios.get('http://localhost:8080/api/incidents').then((response) => {
            console.log(response)

        });
    }, []);


    return (
        <div>
            <h1>Airport search panel</h1>
        </div>
    );


};

export default PropertyDamageRecognitionApp;
