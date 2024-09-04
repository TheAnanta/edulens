"use client";

import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import Card from "@/components/Card";
import Footer from "@/components/Footer";
import React from "react";
import { useRouter } from "next/navigation";

export default function Page() {
  const router = useRouter();

  React.useEffect(() => {
    console.log("locahasldfj");
    if(localStorage === undefined || localStorage.getItem('name') === undefined){
      router.push("/");
    }
  },[localStorage, localStorage.getItem('name')]);
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
          <Card attribute="Name" title="A" key="bi" />
          <Card attribute="hi there" title="B" key="bi" />
          <Card attribute="hi there" title="C" key="bi" />
          <Card attribute="Name" title="A" key="bi" />
          <Card attribute="hi there" title="B" key="bi" />
          <Card attribute="hi there" title="C" key="bi" />
          <Card attribute="Name" title="A" key="bi" />
          <Card attribute="hi there" title="B" key="bi" />
        </div>
      </div>
    </div>
  );
}
