import { useState } from "react";
import { postRequest } from "../api/api";
import { styles } from "../styles/styles";



export default function DaysCalculator() {

  const [days, setDays] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");


  const submit = async (e) => {

    e.preventDefault();
    setLoading(true);
    setError("");
    setDays(null);


    try {
      const res = await postRequest("/number-of-days", {startDate: e.target.startDate.value, endDate: e.target.endDate.value });
      setDays(res.days);

    } catch (err) {

      setError(err.message);

    } finally {

      setLoading(false);
      
    }
  };


  return (
    <section style={styles.section}>
      <h2 style={styles.title}> Number of Days </h2>

      <form onSubmit={submit} style={styles.form}>
        <input type="date" name="startDate" required style={styles.input} />
        <input type="date" name="endDate" required style={styles.input} />
        <button type="submit" style={styles.button(loading)}>
          {loading ? "Calculating..." : "Calculate"}
        </button>
      </form>

      {days !== null && <div style={styles.result}>{days} days</div>}
      {error && <div style={styles.error}>{error}</div>}
    </section>
  );
}
