import Sidebar from "@/components/Sidebar";
import React from "react";
import InfraCard from "./InfraCard";

const infrastructureData = [
  {
    title: "Science Center",
    image:
      "https://www.gitam.edu/sites/default/files/2022-09/Hyderabad-Campus_0.jpg",
  },
  {
    title: "Medical GIMSR",
    image: "https://programmes.gitam.edu/images/campus1.jpg",
  },
  {
    title: "Hostel Rooms",
    image:
      "https://www.gitam.edu/sites/default/files/2023-07/vskp-hostel_0.jpg",
  },
  {
    title: "Hyderabad Campus",
    image:
      "https://www.gitam.edu/sites/default/files/2022-09/Bengaluru-Campus_3.jpg",
  },
  {
    title: "Princeton University - Nassau Hall",
    image:
      "https://images.shiksha.com/mediadata/images/1507540090phpGEZzdx.jpeg",
  },
];

export default function Page() {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div className="grid grid-cols-3 gap-8">
          {infrastructureData.map((infra, index) => (
            <InfraCard key={index} title={infra.title} image={infra.image} />
          ))}
        </div>
      </div>
    </div>
  );
}
