"use client";

import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import Card from "@/components/Card";
import Footer from "@/components/Footer";
import React from "react";
import { useRouter } from "next/navigation";

export default function Page() {
  const [data, setData] = React.useState([]);
  const router = useRouter();

  React.useEffect(() => {
    console.log("locahasldfj");
    if (localStorage === undefined || localStorage.getItem('name') === undefined) {
      router.push("/");
    }

    const fetchData = async () => {
      const response = await fetch(
        "https://raw.githubusercontent.com/Chandan-6/avadaranuvu/main/FacultyData"
      );
      const result = await response.json();

      const filteredData = result.faculty.filter(
        (item: { fullName: string | null; }) => item.fullName === localStorage.getItem('name')
      );

      setData(filteredData[0]);
    };
    fetchData();
  }, [localStorage, localStorage.getItem('name')]);


  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div className="flex space-x-4">
          <div className="text-2xl font-normal">
            Welcome Back!{" "}
            <span className="font-semibold text-3xl uppercase">
              {localStorage.getItem('name')}
            </span>
          </div>
          <AvatarImage />
        </div>
        <div className="grid grid-cols-3 mt-24 gap-8 w-full mb-6">
          {data.map((item, index) => (
            <Card attribute={Object.keys(item)[0]} title="F" key={index} />
          ))}
        </div>
      </div>
    </div>
  );
}
