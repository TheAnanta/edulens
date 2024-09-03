import Sidebar from "@/components/Sidebar";
import AvatarImage from "./avatar";

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex ">
      <Sidebar />
      <div className="flex items-center justify-between space-x-6 pt-36 px-24">
        <div className="text-2xl font-normal">
          Welcome Back!{" "}
          <span className="font-semibold text-3xl uppercase">
            {props.params.id}
          </span>
        </div>
        <AvatarImage />
      </div>
    </div>
  );
}
