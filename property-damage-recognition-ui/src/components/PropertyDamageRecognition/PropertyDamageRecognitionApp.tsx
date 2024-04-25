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
            <h2>Rezultatai</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>POLISAS</th>
                    <th>DATA</th>
                </tr>


                <tr>
                    <th>Company</th>
                    <th>Contact</th>
                    <th>Country</th>
                </tr>
                <tr>
                    <td>Alfreds Futterkiste</td>
                    <td>Maria Anders</td>
                    <td>Germany</td>
                </tr>
                <tr>
                    <td>Centro comercial Moctezuma</td>
                    <td>Francisco Chang</td>
                    <td>Mexico</td>
                </tr>
            </table>

        </div>
    );


};

export default PropertyDamageRecognitionApp;
