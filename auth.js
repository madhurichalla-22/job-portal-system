// Candidate login
async function loginCandidate() {

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    if(!email || !password){
        alert("Enter email & password");
        return;
    }

    try {

        const res = await fetch(
            `http://localhost:8131/candidate/login?email=${email}&password=${password}`,
            { method: "POST" }
        );

        if(!res.ok){
            alert("Invalid login");
            return;
        }

        const data = await res.json();

        console.log("LOGIN RESPONSE:", data);

        // SAVE LOGIN
        localStorage.setItem("candidateId", data.candidateId || data.id);

        alert("Login successful");

        window.location = "candidate-dashboard.html";

    } catch(e){
        console.log(e);
        alert("Server error");
    }
}