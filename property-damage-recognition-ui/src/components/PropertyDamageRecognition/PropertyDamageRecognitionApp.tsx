import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Incident} from './typing';

const PropertyDamageRecognitionApp = () => {
    const [incidents, setIncidents] = useState<Incident[]>([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/incidents').then((response) => {
            setIncidents(response.data);
        });
    }, []);


    return (
        <div>
            <h2>Rezultatai</h2>
            <table>
                <tr>
                    <th>Incidento registravimo numeris</th>
                    <th>Polisas</th>
                    <th>Incidento registracijos data</th>
                </tr>

                {incidents.map((it) => {
                    return (<tr>
                        <td>{it.id}</td>
                        <td>{it.policyNo}</td>
                        <td>{it.createdDate}</td>
                    </tr>)
                })}
            </table>

        </div>
    );


};
export default PropertyDamageRecognitionApp;

