"use client";

import LinearProgress from "@mui/material";
import Sidebar from "@/components/Sidebar";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import React from "react";
import { useRouter } from "next/navigation";
import Card from "@/components/Card";
import Cookies from "js-cookie";
import { useState, useEffect } from "react";

export default function Page() {
  const router = useRouter();
  const [data, setData] = useState( {
    "FacultyID": "F001",
    "FullName": "admin singh",
    "Email": "admin@nitam.edu",
    "Phone-Number": "123-456-7890",
    "Aadhar-Number": "123456789012",
    "gender": "Male",
    "Mother-Name": "Jane Doe",
    "DOB": "1980-01-01",
    "Nationality": "American",
    "DepartmentID": "DEPT01",
    "Role": "Professor",
    "Office-Number": "101",
    "LevelOfEducation": "PhD",
    "DateOfJoining": "2020-01-01",
    "PresentYear": 2023,
    "Semester": "Spring"
  });

  // useEffect(() => {
  //   const fetchData = async () => {
  //     const response = await fetch(
  //       "https://raw.githubusercontent.com/Chandan-6/avadaranuvu/main/FacultyData.json"
  //     );
  //     const result = await response.json();
  //     const filteredData = result.faculty.filter(
  //       (item) => item.FullName === "admin singn"
  //     );

  //     setData(filteredData[0]);
  //   };
  //   fetchData();
  // }, []);

  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div className="flex items-center space-x-4">
          <div className="text-2xl font-normal">
            Welcome Back!{" "}
            <span className="font-semibold text-3xl uppercase">
              {Cookies.get("name")}
            </span>
          </div>
          <AccountCircleIcon />
        </div>
        <div className="grid grid-cols-3 mt-24 gap-8 w-full mb-6">
          {data &&
            Object.entries(data).map(([key, value], index) => (
              <Card
              key={index}
                attribute={value}
                title={key}
              />
            ))}

        </div>
      </div>
    </div>
  );
}
