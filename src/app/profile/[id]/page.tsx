import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import Card from "@/components/Card";
import Footer from "@/components/Footer";

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div className="flex space-x-4">
          <div className="text-2xl font-normal">
            Welcome Back!{" "}
            <span className="font-semibold text-3xl uppercase">
              {props.params.id}
            </span>
          </div>
          <AvatarImage />
        </div>
        <div className="grid grid-cols-3 mt-24 gap-8 w-full mb-6">
          <Card attribute="Name" title="A" key="bi" />
          <Card attribute="hi there" title="B" key="bi" />
          <Card attribute="hi there" title="C" key="bi" />
          <Card attribute="Name" title="A" key="bi" />
          <Card attribute="hi there" title="B" key="bi" />
          <Card attribute="hi there" title="C" key="bi" />
          <Card attribute="Name" title="A" key="bi" />
          <Card attribute="hi there" title="B" key="bi" />
        </div>
        <Footer/>
      </div>
    </div>
  );
}
