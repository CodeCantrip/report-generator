import { useState } from 'react'
import '../App.css'



function ReportPage() {

    const [unitFloor, setUnitFloor] = useState('')
    const [patients, setPatients] = useState([])
    const [selectedPatients,setSelectedPatients] = useState([])
    const [reportPatients, setReportPatients] = useState([])

    async function  handleSearch(){
        const response = await fetch(
            `http://localhost:8080/patients?unitFloor=${unitFloor}`,

            {
                credentials :'include'
            }
        )
        const data = await response.json()
        console.log(data)
        setPatients(data)

    }

    function handlePatientSelection(patient){
        const isSelected = selectedPatients.some(
            (selectedPatient) => selectedPatient.patientId === patient.patientId
        )

        if (isSelected){
            setSelectedPatients(
                selectedPatients.filter(
                    (selectedPatient) => selectedPatient.patientId !== patient.patientId
                )
            )
        } else{
            setSelectedPatients([...selectedPatients, patient])
        }

    }
    function handleGenerateReport(){
        setReportPatients(selectedPatients)
    }

    function renderModality(modality){
        switch (modality.type){
            case 'VentDto':
                return(
                    <p>Vent: {modality.ventMode} - {modality.ventSettings}</p>
                )

            case 'EttDto':
                return(
                    <p>ETT: {modality.ettSize} - {modality.ettPlacement}</p>
                )
            case 'TrachDto':
                return(
                    <p>Trach Size: {modality.trachSize} - {modality.trachType}</p>
                )
            case 'OxygenDto':
                return(
                    <p>O2: {modality.oxygenDevice} - {modality.oxygenSetting}</p>
                )
            case 'NivDto':
                return(
                    <p>Niv: {modality.nivMode} - {modality.nivSettings} - {modality.nivFrequency}</p>
                )
            case 'MedicationDto':
                return(
                    <p>Medication: {modality.medicationName} - {modality.medFrequency}</p>
                )
            case 'CptDto':
                return(
                    <p>CPT: {modality.therapyType} - {modality.cptFrequency}</p>
                )
            default:
                return null
        }
    }
    return (
        <main>
            <h1>Clinical Report Generator</h1>

            <input
                value = {unitFloor}
                onChange={(event) => setUnitFloor(event.target.value)}
            />

            <p>{unitFloor}</p>
            <button onClick={handleSearch}>Search</button>

            {patients.map((patient) =>(
                <div key={patient.patientId}>

                    <input
                        type = 'checkbox'
                        checked={selectedPatients.some(
                            (selectedPatient) =>
                                selectedPatient.patientId === patient.patientId
                        )}
                        onChange={() => handlePatientSelection(patient)}
                    />

                    <h2>{patient.name}</h2>
                    <h2>Room: {patient.room}</h2>
                    <h2>Floor: {patient.unitFloor}</h2>
                </div>
            ))}

            <h2>Selected Patients</h2>
            {selectedPatients.map((patient) =>
                <div key={patient.patientId}>
                    <p>{patient.name} - Room {patient.room}</p>
                </div>
            )}

            <button onClick={handleGenerateReport}>Generate Report</button>

            {reportPatients.map((patient) => (
                <div key = {patient.patientId}>
                <h2>{patient.name}</h2>
                <p>Room: {patient.room}</p>
                <p>Floor: {patient.unitFloor}</p>
                <p>DOB: {patient.dob}</p>
                <p>Code Status: {patient.codeStatus}</p>
                <p>Diagnosis: {patient.diagnosis}</p>

                {patient.modalities.map((modality, index) =>
                <div key = {index}>
                    <p>{renderModality(modality)}</p>
                </div>


                )}

                </div>
            ))}
        </main>


    )
}

export default ReportPage