import {useState} from 'react'
import '../App.css'


function ReportPage() {

    const [unitFloor, setUnitFloor] = useState('')
    const [patients, setPatients] = useState([])
    const [selectedPatients, setSelectedPatients] = useState([])
    const [reportPatients, setReportPatients] = useState([])

    async function handleSearch() {
        const response = await fetch(
            `http://localhost:8080/patients?unitFloor=${unitFloor}`,

            {
                credentials: 'include'
            }
        )
        const data = await response.json()
        console.log(data)
        setPatients(data)

    }

    function handlePatientSelection(patient) {
        const isSelected = selectedPatients.some(
            (selectedPatient) => selectedPatient.patientId === patient.patientId
        )

        if (isSelected) {
            setSelectedPatients(
                selectedPatients.filter(
                    (selectedPatient) => selectedPatient.patientId !== patient.patientId
                )
            )

            setReportPatients(
                reportPatients.filter(
                    (reportPatient) => reportPatient.patientId !== patient.patientId
                )
            )

        } else {
            setSelectedPatients([...selectedPatients, patient])
        }

    }

    function handleGenerateReport() {
        setReportPatients(selectedPatients)
    }

    function renderModality(modality) {
        switch (modality.type) {
            case 'VentDto':
                return (
                    <p><strong>Vent:</strong> {modality.ventMode} - {modality.ventSettings}</p>
                )

            case 'EttDto':
                return (
                    <p><strong>ETT:</strong> {modality.ettSize}  {modality.ettPlacement}</p>
                )
            case 'TrachDto':
                return (
                    <p><strong>Trach Size:</strong> {modality.trachSize}  {modality.trachType}</p>
                )
            case 'OxygenDto':
                return (
                    <p><strong>O2:</strong> {modality.oxygenDevice}  {modality.oxygenSetting}</p>
                )
            case 'NivDto':
                return (
                    <p><strong>Niv:</strong> {modality.nivMode} - {modality.nivSettings}  {modality.nivFrequency}</p>
                )
            case 'MedicationDto':
                return (
                    <p><strong>Medication:</strong> {modality.medicationName}  {modality.medFrequency}</p>
                )
            case 'CptDto':
                return (
                    <p><strong>CPT:</strong> {modality.therapyType}  {modality.cptFrequency}</p>
                )
            default:
                return null
        }
    }

    return (
        <main>
            <h1 className= "first-page-title">Clinical Report Generator</h1>
            <div className="title-underline"></div>
            <p className="title-subtitle">
                Respiratory Care • Clinical Documentation
            </p>

            <div className="patient-search-controls">
            <input className = "patient-search-input"
                value={unitFloor}
                onChange={(event) => {setUnitFloor(event.target.value);
                    if (event.target.value === ""){
                        setPatients([])
                        setSelectedPatients([])
                        setReportPatients([]);
                }
                }}
            />


            <button className="patient-search-button" onClick={handleSearch}>Search</button>
            </div>
            {patients.map((patient) => (
                <div key={patient.patientId} className="patient-search-result">

                    <div className="patient-search-header">
                    <input
                        type='checkbox'
                        checked={selectedPatients.some(
                            (selectedPatient) =>
                                selectedPatient.patientId === patient.patientId
                        )}
                        onChange={() => handlePatientSelection(patient)}
                    />

                    <h2>{patient.lastName}, {patient.firstName}</h2>

                    </div>


                    <p>Room: {patient.room}</p>
                    <p>Floor: {patient.unitFloor}</p>
                </div>
            ))}
            {selectedPatients.length > 0 &&(
                <div className="selected-patients-section">
                    <h2>Selected Patients</h2>
            {selectedPatients.map((patient) =>
                <div key={patient.patientId} className={"selected-patients"}>
                    <span>{patient.lastName}, {patient.firstName}</span> <span>Room: {patient.room}</span>
                </div>
            )}


            <button className="patient-search-button generate-report-button"  onClick={handleGenerateReport}>Generate Report</button>

                </div>
            )}


            {reportPatients.map((patient) => (
                <div key={patient.patientId} className="patient-report">
                    <div className="patient-header">
                        <h2>{patient.lastName}, {patient.firstName}</h2>
                        <p><strong>Room:</strong> {patient.room}</p>
                        <p><strong>Floor:</strong> {patient.unitFloor}</p>
                        <p><strong>DOB:</strong> {patient.dob}</p>
                        <p><strong>Code Status:</strong> {patient.codeStatus}</p>
                        <p><strong>Diagnosis:</strong> {patient.diagnosis}</p>
                    </div>

                    <div className="report-modalities">
                    {patient.modalities.map((modality, index) =>
                        <div key={index}>
                            {renderModality(modality)}
                        </div>
                    )}
                    </div>

                </div>
            ))}

            {reportPatients.length > 0 &&(
                <button className="print-report-button"  onClick={() => window.print()}>Print Report</button>

            )}
        </main>


    )
}

export default ReportPage