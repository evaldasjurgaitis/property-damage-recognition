import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Incident} from './typing';

const PropertyDamageRecognitionApp = () => {
    const [incidents, setIncidents] = useState<Incident[]>([]);
    const [file, setFile] = useState<File | null>(null);

    const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        if (e.target.files) {
            setFile(e.target.files[0]);
        }
    };

    const handleUpload = async () => {
        if (file) {
            console.log("Uploading file...");

            const formData = new FormData();
            formData.append("file", file);

            try {
                // You can write the URL of your server or any other endpoint used for file upload
                const result = await fetch("http://localhost:8080/api/photo/upload-image", {
                    method: "POST",
                    body: formData,
                });

                const data = await result.json();

                console.log(data);
            } catch (error) {
                console.error(error);
            }
        }
    };
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
                        <td>
                            <input
                                type="file"
                                name="myImage"
                                onChange={handleFileChange}
                            />
                        </td>
                        <td>
                            {file && <button onClick={handleUpload}>Upload a file</button>}

                        </td>
                    </tr>)
                })}
            </table>

        </div>
    );


};
export default PropertyDamageRecognitionApp;

