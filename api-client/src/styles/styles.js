export const styles = {
  container: {
    maxWidth: "900px",
    margin: "40px auto",
    fontFamily: "Arial, sans-serif"
  },

  section: {
    background: "#f8f9fa",
    padding: "24px",
    borderRadius: "8px",
    marginBottom: "24px",
    boxShadow: "0 2px 6px rgba(0,0,0,0.08)"
  },

  title: {
    color: "#007bff",
    marginBottom: "16px"
  },

  form: {
    display: "flex",
    gap: "12px",
    flexWrap: "wrap"
  },

  input: {
    padding: "10px",
    flex: 1,
    minWidth: "160px",
    borderRadius: "4px",
    border: "1px solid #ccc"
  },

  button: (loading) => ({
    padding: "10px 20px",
    background: loading ? "#6c757d" : "#007bff",
    color: "#fff",
    border: "none",
    borderRadius: "4px",
    cursor: loading ? "not-allowed" : "pointer"
  }),

  result: {
    marginTop: "16px",
    padding: "14px",
    background: "#d4edda",
    borderRadius: "4px"
  },

  error: {
    marginTop: "16px",
    padding: "14px",
    background: "#f8d7da",
    color: "#721c24",
    borderRadius: "4px"
  },

  tempGrid: {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))",
    gap: "16px",
    marginTop: "16px"
  },

  tempCard: {
    background: "#fff",
    padding: "16px",
    borderRadius: "6px",
    border: "1px solid #ddd"
  }
  
};
