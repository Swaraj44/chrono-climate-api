import { useState } from "react";
import { postRequest } from "../api/api";
import { styles } from "../styles/styles";


export default function NumberToWords() {

  const [words, setWords] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");


  const submit = async (e) => {
    
    e.preventDefault();
    setLoading(true);
    setError("");
    setWords("");

    try {

      const res = await postRequest("/number-to-words", {number: e.target.number.value});
      setWords(res.words);

    } catch (err) {

      setError(err.message);

    } finally {

      setLoading(false);

    }
  };



  return (
    <section style={styles.section}>

      <h2 style={styles.title}> Number to Words</h2>

      <form onSubmit={submit} style={styles.form}>
        <input name="number" placeholder="46.40" required style={styles.input} />
        <button type="submit" style={styles.button(loading)}>
          {loading ? "Converting..." : "Convert"}
        </button>
      </form>

      {words && <div style={styles.result}>"{words}"</div>}
      {error && <div style={styles.error}>{error}</div>}

    </section>
  );
}
