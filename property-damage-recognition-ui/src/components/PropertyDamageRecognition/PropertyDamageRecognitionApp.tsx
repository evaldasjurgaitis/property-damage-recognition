import React, {useState} from 'react';
import {DamageInfo} from './typing';

const PropertyDamageRecognitionApp = () => {
    const [file, setFile] = useState<File | null>(null);
    const [damageInfo, setDamageInfo] = useState<DamageInfo | null>(null);

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
                setDamageInfo(data);
                console.log(data);
            } catch (error) {
                console.error(error);
            }
        }
    };

    const damgeInfoDesc = (damageInfo: DamageInfo) => {
        if (!damageInfo.frontDamages) {
            return (<div>Mašinos vin kodas: {damageInfo.vin}</div>)
        }

        return (<div>
            <br/>
            <div>Pažeistos vietos:</div>
            {damageInfo.frontDamages.bumper &&
                <div><strong>Priekinis bamperis:</strong> {damageInfo.frontDamages.bumper * 100 > 70 ?
                    <strong>{damageInfo.frontDamages.bumper * 100}</strong> : damageInfo.frontDamages.bumper * 100}
                </div>}
            {damageInfo.frontDamages.glass &&
                <div><strong>Priekinis langas: </strong> {damageInfo.frontDamages.glass * 100 > 70 ?
                    <strong>{damageInfo.frontDamages.glass * 100}</strong> : damageInfo.frontDamages.glass * 100}</div>}
            {damageInfo.frontDamages.grill &&
                <div><strong>Priekinės grotelės:</strong> {damageInfo.frontDamages.grill * 100 > 70 ?
                    <strong>{damageInfo.frontDamages.grill * 100}</strong> : damageInfo.frontDamages.grill * 100}</div>}
            {damageInfo.frontDamages.hood &&
                <div><strong>Variklio dangtis: </strong>{damageInfo.frontDamages.hood * 100 > 70 ?
                    <strong>{damageInfo.frontDamages.hood * 100}</strong> : damageInfo.frontDamages.hood * 100}</div>}
            {damageInfo.frontDamages.lampLeft &&
                <div><strong>Priekinė kairė lempa: </strong> {damageInfo.frontDamages.lampLeft * 100 > 70 ?
                    <strong>{damageInfo.frontDamages.lampLeft * 100}</strong> : damageInfo.frontDamages.lampLeft * 100}
                </div>}
            {damageInfo.frontDamages.lampRight &&
                <div><strong>Priekinė dešnė lempa: </strong> {damageInfo.frontDamages.lampRight * 100 > 70 ?
                    <strong>{damageInfo.frontDamages.lampRight * 100}</strong> : damageInfo.frontDamages.lampRight * 100}
                </div>}
        </div>)
    }

    return (
        <div>
            <h2>Turto žalos nustatymas</h2>
            <label>Įkelkite nuotrauką:</label>
            <input
                type="file"
                name="myImage"
                onChange={handleFileChange}
            />
            {file && <button onClick={handleUpload}>Tikrinti</button>}
            {damageInfo && damgeInfoDesc(damageInfo)}
            <br/>
            {damageInfo && (<div>
                <img src={`data:image/jpeg;base64,${damageInfo.base64Output}`}/>
            </div>)}
        </div>
    );


};
export default PropertyDamageRecognitionApp;

