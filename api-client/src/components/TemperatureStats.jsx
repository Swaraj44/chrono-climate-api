import { useState } from "react";
import { postRequest } from "../api/api";
import { styles } from "../styles/styles";


export default function TemperatureStats() {


  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");


  const submit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError("");
    setData(null);

    try {

      const res = await postRequest("/temperature-stats-for-dhaka", {startDate: e.target.startDate.value,endDate: e.target.endDate.value});
      setData(res);

    } catch (err) {

      setError(err.message);

    } finally {

      setLoading(false);

    }
  };


  return (

    <section style={styles.section}>

      <h2 style={styles.title}> Dhaka Temperature</h2>

      <form onSubmit={submit} style={styles.form}>
        <input type="date" name="startDate" required style={styles.input} />
        <input type="date" name="endDate" required style={styles.input} />
        <button type="submit" style={styles.button(loading)}>
          {loading ? "Fetching..." : "Fetch"}
        </button>
      </form>


      {data && (
        <div style={styles.tempGrid}>
          <div style={styles.tempCard}>
            <strong>Min</strong><br />{data.min}°C<br />
            <em>{data.minText}</em>
          </div>

          <div style={styles.tempCard}>
            <strong>Max</strong><br />{data.max}°C<br />
            <em>{data.maxText}</em>
          </div>

          <div style={styles.tempCard}>
            <strong>Average</strong><br />{data.average}°C<br />
            <em>{data.averageText}</em>
          </div>

        </div>
      )}

      {error && <div style={styles.error}>{error}</div>}
      
    </section>
  );

}
