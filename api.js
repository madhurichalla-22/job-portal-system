const BASE_URL = "http://localhost:8131";

/* Candidate Login */
async function candidateLogin(email, password) {
    const res = await fetch(`${BASE_URL}/candidate/login?email=${email}&password=${password}`, {
        method: "POST"
    });
    return res.json();
}

/* Get All Jobs */
async function getAllJobs() {
    const res = await fetch(`${BASE_URL}/job/all`);
    return res.json();
}

/* Apply Job */
async function applyJob(candidateId, jobId) {
    const res = await fetch(`${BASE_URL}/application/apply/${candidateId}/${jobId}`, {
        method: "POST"
    });
    return res.text();
}

/* Post Job */
async function postJob(employerId, jobData) {
    const res = await fetch(`${BASE_URL}/job/post/${employerId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(jobData)
    });
    return res.json();
}

/* Upload Resume */
async function uploadResume(candidateId, file) {
    const formData = new FormData();
    formData.append("file", file);

    const res = await fetch(`${BASE_URL}/candidate/uploadResume/${candidateId}`, {
        method: "POST",
        body: formData
    });
    return res.text();
}
async function loadJobs(){

 const res = await fetch("http://localhost:8131/job/all");

 const jobs = await res.json();

 let html = "";

 jobs.forEach(job => {

   html += `
   <div class="card">
      <h3>${job.title}</h3>
      <p>${job.description}</p>
      <p><b>Location:</b> ${job.location}</p>
      <p><b>Salary:</b> ${job.salary}</p>

      <button onclick="applyJob(${job.id})">
         Apply
      </button>
   </div>
   `;

 });

 document.getElementById("jobs").innerHTML = html;
}