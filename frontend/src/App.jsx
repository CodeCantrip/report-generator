import { useState } from 'react'
import './App.css'



function App() {

    const [unitFloor, setUnitFloor] = useState('')
    const [patients, setPatients] = useState([])
    const [selectedPatients,setSelectedPatients] = useState([])


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
      </main>


  )
}

export default App
