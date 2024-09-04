"use client";
import LinearProgress from "@mui/material";
import Sidebar from "@/components/Sidebar";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import React from "react";
import { useRouter } from "next/navigation";
import Card from "@/components/Card";

export default function Page() {
  const router = useRouter();

  React.useEffect(() => {
    if (
      localStorage === undefined ||
      localStorage.getItem("name") === undefined
    ) {
      router.push("/");
    }
  }, [localStorage, localStorage.getItem("name")]);

  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div className="flex items-center space-x-4">
          <div className="text-2xl font-normal">
            Welcome Back!{" "}
            <span className="font-semibold text-3xl uppercase">
              {localStorage.getItem("name")}
            </span>
          </div>
          <AccountCircleIcon />
        </div>
        <div className="grid grid-cols-3 mt-24 gap-8 w-full mb-6">
          <Card
            pro={45}
            attribute="Your recent activity summary"
            title="Activity"
          />
          <Card
            pro={45}
            attribute="Total projects you're working on"
            title="Projects"
          />
          <Card
            pro={45}
            attribute="Number of messages in your inbox"
            title="Messages"
          />
          <Card
            pro={45}
            attribute="Upcoming deadlines and tasks"
            title="Tasks"
          />
          <Card
            pro={45}
            attribute="Your profile completion status"
            title="Profile"
          />
          <Card
            pro={45}
            attribute="Number of colleagues online"
            title="Connections"
          />
        </div>
      </div>
    </div>
  );
}