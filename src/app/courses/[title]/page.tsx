"use client";
import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import Footer from "@/components/Footer";
import Button from "@mui/material/Button";

export default function Page({ params }: { params: { title: string } }) {
  console.log(params.title);

  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div>
          <div className="text-3xl font-bold mb-8 ">{params.title}</div>
          <div className="flex items-center justify-start space-x-8">
            <div className="p-8 rounded-2xl bg-[var(--secondary-color)]">
              <h1 className="mb-4 text-xl font-bold">Quiz 1</h1>
              <p className="mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Similique earum aut architecto sint eligendi rem facere rerum?
                Eos non ducimus culpa ipsa, vitae optio assumenda architecto?
                Dolores nam sint quasi.
              </p>
              <Button variant="contained" className="w-full">
                Post Marks
              </Button>
            </div>
            <div className="p-8 rounded-2xl bg-[var(--secondary-color)]">
              <h1 className="mb-4 text-xl font-bold">Quiz 2</h1>
              <p className="mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Similique earum aut architecto sint eligendi rem facere rerum?
                Eos non ducimus culpa ipsa, vitae optio assumenda architecto?
                Dolores nam sint quasi.
              </p>
              <Button variant="contained" className="w-full">
                Post Marks
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
