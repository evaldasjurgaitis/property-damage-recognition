export type Incident = {
    id: number;
    createdDate: string | null;
    policyNo: number;
}

export type DamageInfo = {
    licencePlate: string;
    model: string;
    vin: string;
    frontDamages: FrontDamage
    base64Output: string
}

export type FrontDamage = {
    bumper: number | null;
    glass: number | null;
    grill: number | null;
    hood: number | null;
    lampLeft: number | null;
    lampRight: number | null;
}
