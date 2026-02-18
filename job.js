// Load all jobs

   
        async function loadJobs() {

    try {
        const res = await fetch("http://localhost:8131/job/all");
        const jobs = await res.json();

        let html = "";

        jobs.forEach(job => {
            html += `
            <div class="job-card">
                <h3>${job.title}</h3>
                <p>${job.description}</p>
                <p><b>Location:</b> ${job.location}</p>
                <p><b>Salary:</b> ${job.salary}</p>

                <button onclick="applyJob(${job.id})">Apply</button>
            </div>
            <hr/>
            `;
        });

        document.getElementById("jobList").innerHTML = html;

    } catch (e) {
        alert("Cannot load jobs. Backend not connected.");
        console.log(e);
    }
}

// Post job
async function postJob(){

    const employerId = localStorage.getItem("employerId");

    const job = {
        title: document.getElementById("title").value,
        description: document.getElementById("description").value,
        location: document.getElementById("location").value,
        salary: document.getElementById("salary").value
    };

    await fetch(`http://localhost:8131/job/post/${employerId}`,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(job)
    });

    alert("Job posted!")
async function applyJob(jobId){

    const candidateId = localStorage.getItem("candidateId");

    try{
        const res = await fetch(`http://localhost:8131/application/apply/${candidateId}/${jobId}`,{
            method:"POST"
        });

        const msg = await res.text();
        alert(msg);

    }catch(e){
        alert("Error applying job");
    }
}
}