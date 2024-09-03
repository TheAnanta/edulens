import Sidebar from "@/components/Sidebar";
import PlacementChart from "./Placement";

export default function page() {
  return (
    <div>
      <Sidebar />
      <div className="px-72 py-32">
        <PlacementChart />
      </div>
    </div>
  );
}
