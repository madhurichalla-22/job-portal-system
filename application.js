
// APPLY JOB
async function applyJob(jobId){

    const candidateId = localStorage.getItem("candidateId");

if (!candidateId || candidateId === "null" || candidateId === "undefined") {
    alert("Please login first");
    window.location = "../candidate/candidate-login.html";
    return;
}
        alert("Please login first");
        return;
    }

    const res = await fetch(
        `${BASE_URL}/application/apply/${candidateId}/${jobId}`,
        { method:"POST" }
    );

    if(res.ok){
        alert("Applied Successfully");
    }else{
        alert("Already applied or error");
    }



// LOAD MY APPLICATIONS
async function loadMyApplications(){

    const candidateId = localStorage.getItem("candidateId");

if (!candidateId || candidateId === "null" || candidateId === "undefined") {
    alert("Please login first");
    window.location.href = "candidate-login.html";
    return;
}
    if(!candidateId){
        alert("Please login first");
        window.location = "../candidate/candidate-login.html";
        return;
    }

    const res = await fetch(`${BASE_URL}/application/candidate/${candidateId}`);
    const applications = await res.json();

    const div = document.getElementById("applicationsList");
    div.innerHTML = "";

    applications.forEach(app=>{
        div.innerHTML += `
            <div class="job-card">
                <h3>${app.job.title}</h3>
                <p>${app.job.description}</p>
                <p><b>Location:</b> ${app.job.location}</p>
                <p><b>Salary:</b> ${app.job.salary}</p>
            </div>
        `;
    });
}