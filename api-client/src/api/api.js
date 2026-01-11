const BASE_URL = "http://localhost:8080/api";



export async function postRequest(endpoint, payload) {

  
  const response = await fetch(`${BASE_URL}${endpoint}`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(payload)
  });


  if (!response.ok) {
    const error = await response.json();
    throw new Error(error.message || "Request failed");
  }


  return response.json();
}
