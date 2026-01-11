import DaysCalculator from "./components/DaysCalculator";
import NumberToWords from "./components/NumberToWords";
import TemperatureStats from "./components/TemperatureStats";
import { styles } from "./styles/styles";




export default function App() {


  return (
    <div style={styles.container}>

      <h1 style={{ textAlign: "center", marginBottom: "32px" }}> Chrono Climate Api Dashboard </h1>

      <DaysCalculator />
      <NumberToWords />
      <TemperatureStats />

    </div>
  );
}
