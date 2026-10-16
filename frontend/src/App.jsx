import './App.css'
import ReportPage from "./pages/ReportPage.jsx";
import LoginPage from "./pages/LoginPage.jsx";
import { Routes, Route } from 'react-router-dom'
import ProtectedRoute from "./pages/ProtectedRoute.jsx";



function App() {
    return (

        <Routes>
            <Route path="/" element={<LoginPage/>}/>
            <Route path="/reports" element={ <ProtectedRoute>
                <ReportPage/>
            </ProtectedRoute>}/>
        </Routes>
    )
}
export default App
